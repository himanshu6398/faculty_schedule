let login_form = document.getElementById('login-validation');

login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (login_form.checkValidity() === true) {
        document.getElementById("submit-button").style.display = "none";
        document.getElementById("spinner-button").style.display = "block";
        let response = await fetch('api/faculty/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                email: document.getElementById('email').value,
                password: document.getElementById('password').value,
            })
        });
      //  let result = await response.json();
       // console.log(response);
/*
        if(result['emp_id'] !== undefined){
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";

            localStorage.setItem('id', result["emp_id"]);
            localStorage.setItem('user',JSON.stringify(result));

            console.log(localStorage.getItem('id'));
            console.log(localStorage.getItem('user'));
           // console.log(sessionStorage.getItem("student_id"));
            location.href = "courses-fetch.html";
        }
        // if(result['status'] === 200) {
        //     let data = response.json();
        //     document.getElementById("submit-button").style.display = "block";
        //     document.getElementById("spinner-button").style.display = "none";
        //
        //     //sessionStorage.setItem('id', data["emp_id"]);
        //     localStorage.setItem('id', data["emp_id"]);
        //     localStorage.setItem('user',JSON.stringify(data));
        //
        //     location.href = "courses-fetch.html", true;
        // }
        else{
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";

            document.getElementById("login-alert").style.display = "block";
        }
*/
        try{
            let result = await response.json();
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";
            console.log(result);
            //sessionStorage.setItem('id', result["student_id"]);
            localStorage.setItem('id', result["emp_id"]);
            console.log(localStorage.getItem('id'));
            location.href = "courses-fetch.html";
        }catch (err){
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";
            document.getElementById("login-alert").style.display = "block";

        }
    }
});