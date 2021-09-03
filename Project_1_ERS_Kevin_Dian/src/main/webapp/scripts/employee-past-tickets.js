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
        
        getPastRequests(); 

    }


    async function getPastRequests(){
    //fetches lists given user id (using ajax)

    const pastResponse = await fetch(`${domain}/api/employee-pasttickets?authorId=${employeeId}`)
    const pastData = await pastResponse.json();

    console.log(pastData)

    //sort the data
    pastData.data.sort((a,b) => {
        if(a.reimbSubmitted > b.reimbSubmitted)
            return -1
        if(a.reimbSubmitted < b.reimbSubmitted)
         return 1;
    
        return 0;   
    })

    let pastContElem = document.getElementById("past-container")
    pastContElem.innerHTML = ``;

    pastData.data.forEach(list => {
        console.log(list)    
    
    pastContElem.innerHTML += `
        <div class = "past-request-card">    
        <div>Reimbursement Request Id: ${list.reimbId}</div>
        <div>Amount: $${list.reimbAmount}</div>
        <div>Time Submitted: ${new Date (list.reimbSubmitted)}</div>
        <div>Time Resolved: ${new Date (list.reimbResolved)}</div>
        <div>Description: ${list.reimbDescription}</div>
        <div>Receipt: ${list.reimbReceipt}</div>
        <div>ID # of Author: ${list.ersUsersFkAuth}</div>
        <div>First Name of Author: ${list.authorFirstName}</div>
        <div>Last Name of Author: ${list.authorLastName}</div>
        <div>ID # of Resolver: ${list.ersUsersFkReslvr}</div>
        <div>First Name of Resolver: ${list.resolverFirstName}</div>
        <div>Last Name of Resolver: ${list.resolverLastName}</div>
        <div>Status: ${list.reimbStatus}</div>
        <div>Type: ${list.reimbType} </div>
        </div>   

        ` 
    })

}

    //end session and redirect to login when logout button is clicked
    let mainBtn = document.getElementById("main-btn")
    mainBtn.onclick = async function(){
            window.location = `${domain}/employee?authorId=${employeeId}`
    }