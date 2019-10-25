const pkg = require('../package.json')
const Configstore = require('configstore')

const myConf = {
  type: 'db2',
  DATABASE: 'v6db',
  HOSTNAME: '10.110.1.208',
  UID: 'db2inst1',
  PWD: '',
  PORT: '50000',
  PROTOCOL: 'TCPIP',
  TABLE: 'ICA_ITEM_PARMS1',
  CONDITION: 'PACK_BAR,DIST_MODE',
  MODULE: 'IMR',
  FILENAME: 'testMachine',
  PATH: 'pc/ttttest/tttest',
  DESC: '我是功能描述',
  AUTHER: '我是码农的名字'
}

const conf = new Configstore(pkg.name, myConf)

module.exports = {
  type: conf.get('type'),
  DATABASE: conf.get('DATABASE'),
  HOSTNAME: conf.get('HOSTNAME'),
  UID: conf.get('UID'),
  PWD: conf.get('PWD'),
  PORT: conf.get('PORT'),
  PROTOCOL: conf.get('PROTOCOL'),
  TABLE: conf.get('TABLE'),
  CONDITION: conf.get('CONDITION'),
  // 默认ica
  MODULE: conf.get('MODULE')? conf.get('MODULE') : 'ICA',
  // 文件名没有默认取表名
  FILENAME: conf.get('FILENAME')? conf.get('FILENAME') : conf.get('TABLE'),
  // 路径、模块名都没有取ica/basic； 
  // 路径没有，模块imr 去imr/pc
  PATH: conf.get('PATH')? conf.get('PATH') : 
      (conf.get('MODULE')? (conf.get('MODULE')=='ICA'? 'basic' : 'pc') : 
          'basic'),
  DESC: conf.get('DESC'),
  AUTHER: conf.get('AUTHER')
}
