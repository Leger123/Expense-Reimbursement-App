    const urlParams = new URLSearchParams(window.location.search)
    const employeeId = urlParams.get("authorId")

    console.log(employeeId)

    window.onload = async function(){
        
        //check session
        const sessionRes = await fetch(`${domain}/api/check-session`)
        const sessionUserData = await sessionRes.json()
   
        console.log(sessionUserData)
        if(sessionUserData.data){
            if(sessionUserData.data.ersUsersId != employeeId){
                window.location = `${domain}/`
            } 
        }else{
            window.location = `${domain}/`
        }
    
        getPendingRequests();
 
    }


    async function getPendingRequests(){
    //The following const varaibles will fetches the lists given user id (using ajax)

    const pendingResponse = await fetch(`${domain}/api/employee?authorId=${employeeId}`)
    const pendingData = await pendingResponse.json();

    console.log(pendingData)

    //sort the data
    pendingData.data.sort((a,b) => {
        if(a.reimbSubmitted > b.reimbSubmitted)
            return -1
        if(a.reimbSubmitted < b.reimbSubmitted)
            return 1;
        
        return 0;   
    })

    let pendingContElem = document.getElementById("pending-container")
    pendingContElem.innerHTML = ``;

    pendingData.data.forEach(list => {
        
        if(!list.reimbResolved) {
            resolvedRequest = "TBD";
        }
        
        pendingContElem.innerHTML += `
        <div class = "pending-request-card">    
            <div>Reimbursement Request Id: ${list.reimbId}</div>
            <div>Amount: $${list.reimbAmount}</div>
            <div>Time Submitted: ${new Date (list.reimbSubmitted)}</div>
            <div>Time Resolved: ${resolvedRequest}</div>
            <div>Description: ${list.reimbDescription}</div>
            <div>Receipt: ${list.reimbReceipt}</div>
            <div>ID # of Author: ${list.ersUsersFkAuth}</div>
            <div>First Name of Author: ${list.authorFirstName}</div>
            <div>Last Name of Author: ${list.authorLastName}</div>
            <div>ID # of Resolver: ${list.ersUsersFkReslvr}</div>
            <div>First Name of Resolver: ${list.resolverFirstName}</div>
            <div>Last Name of Resolver: ${list.resolverlastName}</div>
            <div id = "status-id">Status: ${list.reimbStatus}</div>
            <div>Type: ${list.reimbType} </div>
        </div>   
        
        ` 

    })

}

let pastButton = document.getElementById("past-btn")

pastButton.onclick = function(){
    window.location = `${domain}/employee-past-tickets?authorId=${employeeId}`   
} 

let createButton = document.getElementById("create-btn")

createButton.onclick = function(){
    window.location = `${domain}/employee-create-ticket?authorId=${employeeId}`   
} 

//end session and redirect to login when logout button is clicked
let logoutBtn = document.getElementById("logout-btn")
logoutBtn.onclick = async function(){
    let logoutRes = await fetch(`${domain}/api/logout`)

    let logoutResData = await logoutRes.json();

    if(logoutResData.success)
        window.location = `${domain}/`
}



    
