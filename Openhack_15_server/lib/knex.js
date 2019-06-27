var knex = require('knex')({
    client: 'mysql',
    connection: {
        host: 'localhost',
        user: process.env.DB_USER || 'root',
        password: process.env.DB_PASS || '8977',
        database: process.env.DB_NAME || 'lynever'
    }
});

module.exports = knex;