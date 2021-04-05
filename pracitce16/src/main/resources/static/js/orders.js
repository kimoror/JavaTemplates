var ordersApp = new Vue({
    el: "#ordersApp",
    data(){
        return{
            order:{
                order_date:''
            },
            orders:[],
            flagOrdersView: false,
            delete_id:'',
            url:{
                allOrders: 'http://localhost:8080/orders/getOrders'
            }
        }
    },
    methods: {
        getOrders: function (){
            axios.get(this.url.allOrders).then((response) => {
                this.orders = response.data
                this.flagOrdersView = true;
                console.log(this.flagItemsView);
                console.log(response.data);
                console.log(this.orders);
            })
        }
    }

})