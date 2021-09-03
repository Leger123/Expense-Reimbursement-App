const urlParams = new URLSearchParams(window.location.search)
const employeeId = urlParams.get("authorId")

console.log(employeeId)

    window.onload = async function(){

        //check session
        const sessionRes = await fetch(`${domain}/api/check-session`)
        const sessionUserData = await sessionRes.json()
   
        console.log(sessionUserData)
        if(sessionUserData.data){
            if(sessionUserData.data.ersUsersId  != employeeId){
                window.location = `${domain}/`
            } 
        }else{
            window.location = `${domain}/`
        }
            

    }


    let createReimbursementForm = document.getElementById("create-ticket-form")
    
    createReimbursementForm.onsubmit = async function(e){
    
        e.preventDefault();


        let amount = document.getElementById("amount").value;
        let description = document.getElementById("description").value;
        let statusType = document.getElementById("status-type").value;

        console.log(amount,description,statusType)

        
        let response = await fetch(`${domain}/api/employee`,{
            method: "POST",
            body: JSON.stringify({
                reimbAmount: amount,
                reimbDescription: description,
                ersUsersFkAuth: employeeId,
                ersReimbursementTypeFk: statusType
            })
        })
    
        let responseData = await response.json();
        console.log(responseData)
        
       if(responseData.success){
            window.location = `${domain}/employee?authorId=${employeeId}`
        }
        
    }

   //end session and redirect to login when logout button is clicked
    let mainBtn = document.getElementById("main-btn")
    mainBtn.onclick = async function(){
        window.location = `${domain}/employee?authorId=${employeeId}`
    }
