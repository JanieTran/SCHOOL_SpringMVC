var url = `http://ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/`

function logIn() {
    var username = $('#username').val()
    var password = $('#password').val()
    var authUrl = `${url}oauth/token?grant_type=password&username=${username}&password=${password}` 
    
    $.ajax ({
        url: authUrl,
        method: 'post',
        headers: {
            Authorization: 'Basic Y2xpZW50LWlkOnNlY3JldA=='
        },
        dataType: "json",
        success: function (result) {
            localStorage.setItem('access_token', result.access_token)
            document.location = 'diseases.html'
        },
        error: function () {
            console.log("Error logging in")
        }
    })
}