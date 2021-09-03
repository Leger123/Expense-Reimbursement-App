const urlParams = new URLSearchParams(window.location.search)
const managerId = urlParams.get("resolverId")

    console.log(managerId)

    window.onload = async function(){
       //check session
        const sessionRes = await fetch(`${domain}/api/check-session`)
        const sessionUserData = await sessionRes.json()

        console.log(sessionUserData)
        if(sessionUserData.data){
            if(sessionUserData.data.ersUsersId != managerId){
                window.location = `${domain}/`
            } 
        }else{
            window.location = `${domain}/`
        }
         
        getAllRequests()

    }
    
    async function getAllRequests(){
    //The following const varaibles will fetches the lists given user id (using ajax)

    const allResponse = await fetch(`${domain}/api/financialmanager`);
    const allData = await allResponse.json();

    console.log(allData)

    //sort the data
    allData.data.sort((a,b) => {
        if(a.reimbSubmitted > b.reimbSubmitted)
            return -1
        if(a.reimbSubmitted < b.reimbSubmitted)
            return 1;
        
        return 0;   
    })

    let allContElem = document.getElementById("all-container")
    allContElem.innerHTML = ``;

    allData.data.forEach(list => {  

        //This will check to see if 
        if(!list.reimbResolved) {
            resolvedRequest = "TBD";

            allContElem.innerHTML += `
        <div class = "all-request-card">    
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
            <div>Last Name of Resolver: ${list.resolverLastName}</div>
            <div id = "status-id">Status: ${list.reimbStatus}</div>
            <div>Type: ${list.reimbType} </div>
            <div>
                <button class="btn btn-success" onclick = "approveButtonFunction(${list.reimbId})" id="approve-btn">Approve</button>
                <button class="btn btn-danger" onclick = "denyButtonFunction(${list.reimbId})" id="deny-btn">Deny</button>
            </div>
        </div>   
        
        ` 
        }
        

        if(list.reimbResolved) {
            resolvedRequest = new Date(list.reimbResolved);
            allContElem.innerHTML += `
        <div class = "all-request-card">    
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
            <div>Last Name of Resolver: ${list.resolverLastName}</div>
            <div id = "status-id">Status: ${list.reimbStatus}</div>
            <div>Type: ${list.reimbType} </div>
        </div>   
        
        ` 
        }  
    })
}

    let allButton = document.getElementById("all-btn")
    allButton.onclick = function(){
        getAllRequests()
    }

    let pendingRequestsButton = document.getElementById("pending-btn")
    pendingRequestsButton.onclick =  async function getAllRequests(){
        
        const pendingRequestsResponse = await fetch(`${domain}/api/financialmanager`);
        const pendingRequestsData = await pendingRequestsResponse.json();
    
        console.log(pendingRequestsData)
    
        //sort the data
        pendingRequestsData.data.sort((a,b) => {
            if(a.reimbSubmitted > b.reimbSubmitted)
                return -1
            if(a.reimbSubmitted < b.reimbSubmitted)
                return 1;
            
            return 0;   
        })
    
        let allContElem = document.getElementById("all-container")
        allContElem.innerHTML = ``;
    
        pendingRequestsData.data.forEach(list => {  
    
            //This will check to see if     
            if(!list.reimbResolved) {
                resolvedRequest = "TBD";
                allContElem.innerHTML += `
            <div class = "all-request-card">    
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
                <div>Last Name of Resolver: ${list.resolverLastName}</div>
                <div id = "status-id">Status: ${list.reimbStatus}</div>
                <div>Type: ${list.reimbType} </div>
                <div>
                    <button class="btn btn-success" onclick = "approveButtonFunction(${list.reimbId})" id="approve-btn">Approve</button>
                    <button class="btn btn-danger" onclick = "denyButtonFunction(${list.reimbId})" id="deny-btn">Deny</button>
                </div>
            </div>   
            
            ` 
            }  
        })    
    
    }    

    let approvedRequestsButton = document.getElementById("approved-btn")
    approvedRequestsButton.onclick =  async function getAllRequests(){
        
        const approvedRequestsResponse = await fetch(`${domain}/api/financialmanager`);
        const approvedRequestsData = await approvedRequestsResponse.json();
    
        console.log(approvedRequestsData)
    
        //sort the data
        approvedRequestsData.data.sort((a,b) => {
            if(a.reimbSubmitted > b.reimbSubmitted)
                return -1
            if(a.reimbSubmitted < b.reimbSubmitted)
                return 1;
            
            return 0;   
        })
    
        let allContElem = document.getElementById("all-container")
        allContElem.innerHTML = ``;
    
        approvedRequestsData.data.forEach(list => {  
    
            //This will check to see if     
            if(list.reimbStatus == "Approved") {
                resolvedRequest = new Date(list.reimbResolved);
                allContElem.innerHTML += `
            <div class = "all-request-card">    
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
                <div>Last Name of Resolver: ${list.resolverLastName}</div>
                <div id = "status-id">Status: ${list.reimbStatus}</div>
                <div>Type: ${list.reimbType} </div>
            </div>   
            
            ` 
            }  
        })    
    
    }    

    let deniedRequestsButton = document.getElementById("denied-btn")
    deniedRequestsButton.onclick =  async function getAllRequests(){
        
        const deniedRequestsResponse = await fetch(`${domain}/api/financialmanager`);
        const deniedRequestsData = await deniedRequestsResponse.json();
    
        console.log(deniedRequestsData)
    
        //sort the data
        deniedRequestsData.data.sort((a,b) => {
            if(a.reimbSubmitted > b.reimbSubmitted)
                return -1
            if(a.reimbSubmitted < b.reimbSubmitted)
                return 1;
            
            return 0;   
        })
    
        let allContElem = document.getElementById("all-container")
        allContElem.innerHTML = ``;
    
        deniedRequestsData.data.forEach(list => {  
    
            //This will check to see if     
            if(list.reimbStatus == "Denied") {
                resolvedRequest = new Date(list.reimbResolved);
                allContElem.innerHTML += `
            <div class = "all-request-card">    
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
                <div>Last Name of Resolver: ${list.resolverLastName}</div>
                <div id = "status-id">Status: ${list.reimbStatus}</div>
                <div>Type: ${list.reimbType} </div>
            </div>   
            
            ` 
            }  
        })    
    
    }
    
    let approveButton = document.getElementById("approve-btn")
    async function approveButtonFunction(reimbId){

            let resolver = managerId;
            let status = 2;
            let idofReimbursement = reimbId;

            let response = await fetch(`${domain}/api/financialmanager`,{
            method: "PATCH",
            body: JSON.stringify({
                ersUsersFkReslvr: resolver,
                ersReimbursementStatusFk: status,
                reimbId: idofReimbursement
            })
        })
    
        let responseData = await response.json();
        console.log(responseData)
        
       if(responseData.success){
            window.location = `${domain}/financial-manager?resolverId=${managerId}`
        }
    } 

    let denyButton = document.getElementById("deny-btn")
    
    async function denyButtonFunction(reimbId){
        
            let resolver = managerId;
            let status = 3;
            let idofReimbursement = reimbId;

            let response = await fetch(`${domain}/api/financialmanager`,{
            method: "PATCH",
            body: JSON.stringify({
                ersUsersFkReslvr: resolver,
                ersReimbursementStatusFk: status,
                reimbId: idofReimbursement
            })
        })
    
        let responseData = await response.json();
        console.log(responseData)
        
       if(responseData.success){
            window.location = `${domain}/financial-manager?resolverId=${managerId}`
        }
    } 

    //end session and redirect to login when logout button is clicked
    let logoutBtn = document.getElementById("logout-btn")
    logoutBtn.onclick = async function(){
    let logoutRes = await fetch(`${domain}/api/logout`)

    let logoutResData = await logoutRes.json();

    if(logoutResData.success)
        window.location = `${domain}/`
}





