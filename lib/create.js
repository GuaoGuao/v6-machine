const fs = require('fs')
const humps = require('humps')
const conf = require('./config')
const utils = require('./utils')

const funQueryTable = conf.TABLE.toUpperCase()
const fileName = humps.decamelize(conf.FILENAME).toLowerCase()
// 全大写下划线
const tableNameDecameUpper = humps.decamelize(fileName).toUpperCase()
// 标准驼峰
const tableNameCamel = humps.camelize(fileName)
// 大驼峰，第一个字母也是大写
const tableNameCamelBig = tableNameCamel.charAt(0).toUpperCase() + tableNameCamel.slice(1)
// 全小写不带下划线
const tableNameLower = tableNameCamel.toLowerCase()

const moduleName = conf.MODULE.toLowerCase()
const funDesc = conf.DESC || tableNameDecameUpper
const funAuther = conf.AUTHER || '代码机生成' + tableNameDecameUpper + '表'
let now = new Date()
const funDate = `${now.getFullYear()}-${now.getMonth()+1}-${now.getDate()}`
const funCond = (conf.CONDITION || '0').split(',')
const funPath = conf.PATH
const funPathDot = conf.PATH.split('/').join('.')
const funPathNoFirst = conf.PATH.split('/').length>1? conf.PATH.slice(conf.PATH.indexOf('/') + 1)+'/' : ''
console.log(funPath)

const dirArr = __dirname.split("\\")
dirArr.pop()
const dirMainStr = dirArr.join("\\")

let create = data => {
  
  createXml()
  
  createJsp(data)

  createJava(data)

}

function createXml() {
  let modelDir = `${dirMainStr}/assets/model/tableNameLowerconf.xml`
  let data = fs.readFileSync(modelDir, 'utf-8');

  data = data.replace(/tableNameCamelBig/g, tableNameCamelBig)
  data = data.replace(/tableNameCamel/g, tableNameCamel)
  data = data.replace(/tableNameLower/g, tableNameLower)
  data = data.replace(/moduleName/g, moduleName)
  data = data.replace(/funPathDot/g, funPathDot)
  data = data.replace(/funPathNoFirst/g, funPathNoFirst)

  utils.mkFile(`${process.cwd()}/$war/WEB-INF/conf/${moduleName}/${funPath}/${tableNameLower}/${tableNameLower}conf.xml`, data)
}

function createJsp(tableColumnData) {
  let modelDir = `${dirMainStr}/assets/model/tableNameLower_query_init.jsp`
  let modelDirDefault = `${dirMainStr}/assets/model/default.jsp`
  let data = fs.readFileSync(modelDir, 'utf-8')
  let dataDefault = fs.readFileSync(modelDirDefault, 'utf-8')

  data = data.replace(/tableNameCamelBig/g, tableNameCamelBig)
  data = data.replace(/tableNameLower/g, tableNameLower)

  // 1:获取页面条件
  // 2：html
  // 3：组织表格列
  // 4：组织表格居右列
  let funJspModel1 = ""
  let funJspModel2 = ""
  let funJspModel3 = ""
  let funJspModel4 = ""
  let model1 = `
                condCamelSearch: $('#condCamelSearch').val(),`
  let model2 = `
          <td class="queryLabelTd"><label>condUpper： </label></td>
          <td><input type="text" id="condCamelSearch"  value="\${condCamelSearch}" /></td>`
  let model3 = `
                        {
                          "id": "condUpper",
                          "name": "condUpper",
                          "field": "condUpper",
                          "width": 100
                        },`
  funCond.forEach( item => {
    let cond = item
    let itemModel1 = model1
    let itemModel2 = model2
    // 条件是数字
    if (/^[0-9]+$/.test(cond)) {
      cond = tableColumnData[cond].name
    }
    let condUpper = cond.toUpperCase()
    let condCamel = humps.camelize(cond.toLowerCase())
    itemModel1 = itemModel1.replace(/condCamel/g, condCamel)
    itemModel2 = itemModel2.replace(/condUpper/g, condUpper)
    itemModel2 = itemModel2.replace(/condCamel/g, condCamel)
    funJspModel1 = funJspModel1 + itemModel1
    funJspModel2 = funJspModel2 + itemModel2
  })

  tableColumnData.forEach( item => {
    let itemModel3 = model3
    let condUpper = item.name.toUpperCase()
    itemModel3 = itemModel3.replace(/condUpper/g, condUpper)
    funJspModel3 = funJspModel3 + itemModel3

    funJspModel4 = funJspModel4 + '"' + item.name.toUpperCase() + '", '
  })

  data = data.replace(/funJspModel1/g, funJspModel1)
  data = data.replace(/funJspModel2/g, funJspModel2)
  data = data.replace(/funJspModel3/g, funJspModel3)
  data = data.replace(/funJspModel4/g, funJspModel4)
  data = data.replace(/funDesc/g, funDesc)
  data = data.replace(/funPathDot/g, funPathDot)

  utils.mkFile(`${process.cwd()}/$war/jsp/com/v6/screen/${moduleName}/${funPath}/${tableNameLower}/${tableNameLower}_query_init.jsp`, data)
  utils.mkFile(`${process.cwd()}/$war/jsp/com/v6/layout/${moduleName}/${funPath}/${tableNameLower}/default.jsp`, dataDefault)

}

function createJava(tableColumnData) {
  let modelDir = `${dirMainStr}/assets/model/java`
  let dirFiles = fs.readdirSync(modelDir)

  dirFiles.forEach( item => {

    let fileName = item.replace('tableNameCamelBig', tableNameCamelBig)
    let data = fs.readFileSync(modelDir + '/' + item, 'utf-8')

    data = data.replace(/tableNameDecameUpper/g, tableNameDecameUpper)
    data = data.replace(/tableNameCamelBig/g, tableNameCamelBig)
    data = data.replace(/tableNameCamel/g, tableNameCamel)
    data = data.replace(/tableNameLower/g, tableNameLower)

    data = data.replace(/funDesc/g, funDesc)
    data = data.replace(/funAuther/g, funAuther)
    data = data.replace(/funDate/g, funDate)
    data = data.replace(/moduleName/g, moduleName)
    data = data.replace(/funPathDot/g, funPathDot)
    data = data.replace(/funQueryTable/g, funQueryTable)

    // 处理xml文件内容
    if (item.slice(item.length-3)=='xml') {
      
      let funSqlMapModel = ""
      let model = `
            <if test="condLSearch != null  and condLSearch != '' ">
                AND condU=#{condLSearch}
            </if>`
      funCond.forEach( item => {
        let cond = item
        let itemModel = model
        // 条件是数字
        if (/^[0-9]+$/.test(cond)) {
          cond = tableColumnData[cond].name
        }
        condU = cond.toUpperCase()
        condL = humps.camelize(cond.toLowerCase())
        itemModel = itemModel.replace(/condU/g, condU)
        itemModel = itemModel.replace(/condL/g, condL)
        funSqlMapModel = funSqlMapModel + itemModel
      })
      data = data.replace(/funSqlMapModel/g, funSqlMapModel)
    }

    // 处理cmd文件内容
    if (item.slice(item.length-8)=='Cmd.java'
      && item.slice(item.length-12)!='InitCmd.java') {
      let funCmdModel = ""
      let model = `
          String condCamelSearch = req.getParameter("condCamelSearch");
          paramMap.put("condCamelSearch", condCamelSearch);`
      funCond.forEach( item => {
        let cond = item
        let itemModel = model
        // 条件是数字
        if (/^[0-9]+$/.test(cond)) {
          cond = tableColumnData[cond].name
        }
        condCamel = humps.camelize(cond.toLowerCase())
        itemModel = itemModel.replace(/condCamel/g, condCamel)
        funCmdModel = funCmdModel + itemModel
      })
      data = data.replace(/funCmdModel/g, funCmdModel)
    }

    utils.mkFile(`${process.cwd()}/java/src/com/v6/${moduleName}/${funPath}/${tableNameLower}/${fileName}`, data)

  })
}

module.exports = create