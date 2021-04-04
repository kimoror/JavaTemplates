var app = new Vue({
    el:"#app",
    data() {
        return {
            item: {
                name: '',
                creation_date: '',
                price: ''
            },
            items: [],
            flagItemsView: false,
            url: {
                allItems: 'http://localhost:8080/items/getItems',
                postItem: 'http://localhost:8080/addItem'
            },
        }
    },
    methods: {
        getItems: function () {
            axios.get(this.url.allItems).then((response) => {
                this.flagItemsView = true;
                console.log(this.flagItemsView);
                console.log(response.data);
                this.items = response.data;
            })
        },
        postItems: function(){
            //TODO Здесь может быть ошибка
            // console.log(this.item)
            let newItem = {
                name: this.item.name,
                date: this.item.creation_date,
                price: this.item.price
            };
            // this.item.creation_date = new Date(this.item.creation_date);
            // console.log(this.item)
            console.log(newItem);
            axios.post('http://localhost:8080/addItem', {
                name: this.item.name,
                date:this.item.creation_date,
                price:this.item.price
            }).then((response) => {
                console.log(response);
            }).catch((err) => console.log(err));
        },
        testPost: function (){
            axios.post('http://localhost:8080/items/addItem', {
                name: this.item.name,
                creation_date:this.item.creation_date,
                price:this.item.price
            }).then((response) => {
                console.log(this.item.name)
                console.log(response);
            })
        }
    }
})