var obj1 = new Vue({    <!--内部绑定V元素和M数据-->
    el: "#obj1",
    data: {       <!--M: 模型层-->
        attribute: "title",
        message: "Hello vue !!!"
    },
    methods: {
        fun1: function () {
            console.log("Hello vue");
        }
    },
    created: function () {
        console.log("Created");
    }
});

