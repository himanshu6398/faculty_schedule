let user;

function start() {
    loginTest();
    fetch_courses();
    // fetch_schedule();
    // fetch_student(button);
}
window.onload = start;

async function fetch_courses(){

    let response = await fetch("api/faculty/getCourses/"+localStorage.getItem('id')+"/");
    let courses = await response.json(); // read response body and parse as JSON
    console.log(courses);

    let table_data = document.getElementById("table_id_data");
    table_data.innerHTML = '';


    for (let i = 0; i<courses.length; i++) {
        let tr_data = document.createElement('tr');
        tr_data.innerHTML = '<th scope="row">' + (i + 1) + '</th>\n' +
            '            <td>' + courses[i]['course_code'] + '</td>\n' +
            '            <td>' + courses[i]['name'] + '</td>\n' +
            '            <td>' + courses[i]['credits'] + '</td>\n' +
            '             <td>' + courses[i]['term'] + '</td>\n' +
            '             <td>' + courses[i]['year'] + '</td>\n' +
            '             <td>' + courses[i]['capacity'] + '</td>\n' +
            '<td><button class="btn btn-lg btn-primary btn-block" id="' + courses[i]['course_id'] + '"  type="submit" onclick="fetch_student(' + courses[i]['course_id'] + ')">\n' +
            '        enrolled students\n' +
            '    </button></td>           ';

        // console.log(document.getElementById('o'));
        table_data.appendChild(tr_data);
    }
}
// async function fetch_schedule() {
//     let response = await fetch("api/faculty/getTimeTable/" + user['emp_id'] + "/");
//     let timeTable = await response.json(); // read response body and parse as JSON
//     console.log(timeTable);
//
//     let table_display = document.getElementById("table_fill_data");
//     table_display.innerHTML = '';
//     // if(show) {
//     for (let i = 0; i < timeTable.length; i++) {
//         let tr_data = document.createElement('tr');
//         tr_data.innerHTML = '<th scope="row">' + (i + 1) + '</th>\n' +
//             '            <td>' + timeTable[i]['course_code'] + '</td>\n' +
//             '            <td>' + timeTable[i]['day'] + '</td>\n' +
//             '            <td>' + timeTable[i]['time'] + '</td>\n' +
//             '             <td>' + timeTable[i]['room_no'] + '</td>';
//         table_display.appendChild(tr_data);
//     }
//     // }
// }

async function fetch_student(course_id) {

    localStorage.setItem('id_course',course_id);
    location.href = "student-details.html";
}

async function fetch_schedule() {

    location.href = "fetch-schedule.html";
}

function loginTest(){

    if(localStorage.getItem('id')===undefined){
        location.href = "index.html";
    }else{
        console.log(localStorage.getItem('id'));
        console.log(localStorage.getItem('user'));
        user = JSON.parse(localStorage.getItem('user'));
    }

}