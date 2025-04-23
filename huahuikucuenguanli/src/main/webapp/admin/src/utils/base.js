const base = {
    get() {
        return {
            url : "http://localhost:8080/huahuikucuenguanli/",
            name: "huahuikucuenguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/huahuikucuenguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "花卉库存管理系统"
        } 
    }
}
export default base
