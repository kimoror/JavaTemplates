var app = new Vue({
    el:"#app",
    data: {
        // item:{
        //     name:'',
        //     creation_date: '',
        //     price: null
        // },
        message:'ass',
        items:[],
        flagItemsView: false,
        url:{
            allItems: 'http://localhost:8080/items/getItems',
            postItem:'http://localhost:8080/addItem'
        }
    },
    methods: {
        getItems: function () {
            axios.get(this.url.allItems).then((response) => {
                this.flagItemsView = true;
                console.log(this.flagItemsView)
                console.log(response.data);
                this.items = response.data;
            })
        }
        ,
        // postItems: function(){
        //     //TODO Здесь может быть ошибка
        //     this.item.creation_date = new Date(this.item.creation_date);
        //     console.log(this.item)
        //     axios.post(this.url.postItems(), this.item)
        // }
    }
})