
const fs = require('fs')

let res = {}

res.mkFile = (url, data) => {
  try {

    let dirArr = url.split("/")
    dirArr.pop()

    tempUrl = dirArr[0]
    dirArr.forEach( (dirName, index) => {
      if (index>0) {
        tempUrl = tempUrl + '/' + dirName
      }
      if (!fs.existsSync(tempUrl)) {
        fs.mkdirSync(tempUrl);  
      }
    })

    fs.writeFileSync(url, data)
    return true
    
  } catch (e) {
    console.log(e)
    return false
  }
}

module.exports = res