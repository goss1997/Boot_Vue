const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: true,
  chainWebpack: (config) => {
    config.plugin("define").tap((definitions) => {
      Object.assign(definitions[0], {
        __VUE_OPTIONS_API__: "true",
        __VUE_PROD_DEVTOOLS__: "false",
        __VUE_PROD_HYDRATION_MISMATCH_DETAILS__: "false",
      });
      return definitions;
    });
  },
});

// vue.js 프록시 설정
// const target = "http://localhost:8080";
// module.exports = {
//   devServer: {
//     port: 8080,
//     proxy: {
//       "/api": {
//         target,
//         changOrigin: true,
//       },
//     },
//   },
// };
