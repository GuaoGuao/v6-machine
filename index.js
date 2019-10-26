#! /usr/bin/env node
const Spinner = require('cli-spinner').Spinner
const create = require('./lib/create')
const connect = require('./lib/connect')

const querySpinner = new Spinner('%s 数据库查询中...')
querySpinner.setSpinnerString('|/-\\')
querySpinner.start()

connect((data) => {
  querySpinner.stop(true)

  const createSpinner = new Spinner('%s 努力构建中...')
  createSpinner.setSpinnerString('|/-\\')
  createSpinner.start()

  create(data)
  
  createSpinner.stop(true)

},
() => {
  querySpinner.stop(true)
})