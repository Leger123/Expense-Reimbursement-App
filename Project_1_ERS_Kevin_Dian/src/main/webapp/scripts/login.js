let loginForm = document.getElementById("login-form");

 window.onload = async function(){
    const sessionRes = await fetch(`${domain}/api/check-session`)
    const sessionUserData = await sessionRes.json();

    if(sessionUserData.data){
        if(sessionUserData.data.ersRoleIdFk === 1)
        {
            window.location = `${domain}/employee?authorId=${sessionUserData.data.ersUsersId}`
        }
        else if(sessionUserData.data.ersRoleIdFk === 2){
            window.location = `${domain}/financial-manager?resolverId=${sessionUserData.data.ersUsersId}` 
        }
    }
} 

    loginForm.onsubmit = async function(e){
        e.preventDefault();
    
        //get values from the input field
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;
    
        console.log(username,password)
    
        //how do we send values to the backend?
        let response = await fetch(`${domain}/api/login`,{
            method: "POST",
            body: JSON.stringify({
                ersUsername: username,
                ersPassword: password
            })
        })
    
        let responseData = await response.json();
        console.log(responseData)
    
        if(responseData.success && responseData.data.ersRoleIdFk === 1){
            window.location = `${domain}/employee?authorId=${responseData.data.ersUsersId}`
        }
        else if (responseData.success && responseData.data.ersRoleIdFk === 2){
            window.location = `${domain}/financial-manager?resolverId=${responseData.data.ersUsersId}`
        }else{
            let messageElem = document.getElementById("login-message")
            messageElem.style = "background-color: white;"
            messageElem.innerText = responseData.message
        }
    }
