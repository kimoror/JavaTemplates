var registrationApp = new Vue({
    el:"#registration",
    data(){
        return{
            user: {
                email:'',
                password:'',
                first_name:'',
                last_name:''
            },
            url:{
                registration: 'http://localhost:8080/auth/add'
            }
        }
    },
    methods: {
        registration: function () {
            //TODO Здесь ошибка мб
            // axios.post('http://localhost:8080/auth/add',{
            //     email: this.user.email,
            //     password: this.user.password,
            //     first_name: this.first_name,
            //     last_name: this.last_name
            // }).then((response) => {
            //     console.log(response);
            // })
            axios.post(this.url.registration,this.user).then((response) => {
                console.log(response);
                console.log(this.user)
            })
        }
    }
})