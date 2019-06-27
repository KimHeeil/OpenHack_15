var knex = require('../lib/knex');
var express = require('express');
//var app = express();
var router = express.Router();

/* GET users listing. */
router.get('/', async function(req, res, next) {
  try {
    var result = await knex.raw('select * from humaninfo;');
    res.json(result[0]);
  } catch (err) {
    res.json(err);
  }
});

router.get('/:id', function(req, res, next) {
  var id = req.params.id;
  knex.raw('select * from humaninfo where seq = ?;', [id])
  .then(function (result) {
    console.log(result);
    res.json(result[0][0]);
  })
  .catch(function (err) {
    res.json(err);
  })
});

router.post('/post', async function (req, res) {
  var result = req.body;
  console.log(result);

  var now = new Date();
  var dateString = `${now.getHours()}:${now.getMinutes()}`;

  var result = await knex.insert({
    name: result.name,
    date: result.date,
    price: result.price,
    time: dateString,
  }).into('humaninfo');

  console.log(result);

  res.sendStatus(200);
});

module.exports = router;
