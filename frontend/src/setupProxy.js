const {createProxyMiddleware} = require('http-proxy-middleware');

module.exports = function (app) {
    app.use(
        '/frontend',
        createProxyMiddleware({
            target: 'http://localhost:8090',
            changeOrigin: true,
            ws: true
        })
    );
};