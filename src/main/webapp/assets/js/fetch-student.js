let s;

function start() {
    Test();
    fetch_students();
}
window.onload = start;

function Test(){

    if(localStorage.getItem('id_course')==undefined){
        location.href = "index.html";
    }else{
        console.log(localStorage.getItem('id_course'));
    }
}

async function fetch_students() {
    let response = await fetch("api/student/getStudents/"+localStorage.getItem('id_course')+"/");
    let students = await response.json();
    console.log(students);

    let table_data = document.getElementById("table_id_data");
    table_data.innerHTML = '';
    for (let i = 0; i<students.length; i++){
        let tr_data = document.createElement('tr');
        tr_data.innerHTML = '<th scope="row">'+(i+1)+'</th>\n' +
            '            <td>'+students[i]['rollno']+'</td>\n' +
            '            <td>'+students[i]['first_name']+'</td>\n' +
            '            <td>'+students[i]['last_name']+'</td>\n' +
            '            <td>'+students[i]['email']+'</td>';
        table_data.appendChild(tr_data);
    }

}