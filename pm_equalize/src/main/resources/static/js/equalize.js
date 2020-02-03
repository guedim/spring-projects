function performPost() {
    
    var account = getAccount();
    var signature = getSignature();

    axiosInstance.post('/equalize/confirm/' + account, {
        signature : signature
    })
        .then(function (response) {
            console.log(response);
            showConfirmationToUser("Your account payment methods are now standardized");
        })
        .catch(function (error) {
            console.log(error);
            showConfirmationToUser("We could not standarize your account's payments methods.");
        });
}

function showConfirmationToUser(message) {
    var userMessage = document.getElementById("userMessage");
    userMessage.innerHTML = message;
}

function getSignature() {
    var url_string = window.location.href;
    var url = new URL(url_string);
    var signature = url.searchParams.get("signature");
    return signature;
}

function getAccount() {
    return location.pathname.split('/')[2];
}

const apiURL = window.location.hostname; //Endpoint del API
console.log(apiURL);

const axiosInstance = axios.create({
    //baseURL: apiURL,
    timeout: 1000
});

performPost();