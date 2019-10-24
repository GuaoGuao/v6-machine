
const conf = require('./config')
var mysql = require('mysql');
var ibmdb = require('ibm_db');

let connect = null

if (conf.type === 'db2') {
  connect = db2Con
} else if (conf.type === 'mysql') {
  connect = mysqlCon
}

function db2Con(callback=function(){}){
  // 这里不知道为啥换行就连不上了
  let ibmConf = `DATABASE=${conf.DATABASE};HOSTNAME=${conf.HOSTNAME};UID=${conf.UID};PWD=${conf.PWD};PORT=${conf.PORT};PROTOCOL=${conf.PROTOCOL}`
  ibmdb.open(ibmConf, function (err,conn) {
    if (err) {
      console.log("connect error")
      return console.log(err);
    }
    
    conn.query("select * from sysibm.columns where TABLE_NAME='" + conf.TABLE + "'", function (err, data) {
      if (err) {
        console.log("query error")
        console.log(err);
      } else {
        let res = []
        data.forEach( (item) => {
          res.push({
            name: item.COLUMN_NAME,
            type: item.DATA_TYPE
          })
        })        
        callback(res)
      }
   
      conn.close(function () {
        console.log('done');
      });
    });
  });
}

function mysqlCon(callback=function(){}) {
  var connection = mysql.createConnection({
    host     : conf.HOSTNAME,
    user     : conf.UID,
    password : conf.PWD,
    database : conf.DATABASE
  });
   
  connection.connect()
   
  connection.query('desc '+conf.TABLE, function (err, rows, fields) {
    if (err) {
      console.log("query error")
      console.log(err);
    } else {
      callback(rows)
    }
  })
   
  connection.end()
}



module.exports = connect
