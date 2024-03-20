const axios = require('axios');
const util = require('util');
const host = 'http://localhost:9200';
const headers = {
  'Content-Type': 'application/json',
};
let options = {
  method: 'POST',
  headers,
};

const url = `${host}/books/_search?pretty`;

const body = {
  query: {
    bool: {
      must: { match_all: {} },
      filter: {
        range: {
          reviews: {
            gte: 10,
          },
        },
      },
    },
  },
};

axios({
  method: 'GET',
  url,
  data: body,
}).then(function (resp) {
  console.log(util.inspect(resp.data, false, null, true));
});

//
