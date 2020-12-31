function start() {
    Test();
    fetch_schedule();
}
window.onload = start;

function Test(){

    if(localStorage.getItem('id')===undefined){
        location.href = "index.html";
    }else{
        console.log(localStorage.getItem('id'));
    }
}

async function fetch_schedule() {
    let response = await fetch("api/faculty/getTimeTable/" + localStorage.getItem('id') + "/");
    let timeTable = await response.json(); // read response body and parse as JSON
    console.log(timeTable);

    let table_display = document.getElementById("table_fill_data");
    table_display.innerHTML = '';
    // if(show) {
    for (let i = 0; i < timeTable.length; i++) {
        let tr_data = document.createElement('tr');
        tr_data.innerHTML = '<th scope="row">' + (i + 1) + '</th>\n' +
            '            <td>' + timeTable[i]['course_code'] + '</td>\n' +
            '            <td>' + timeTable[i]['day'] + '</td>\n' +
            '            <td>' + timeTable[i]['time'] + '</td>\n' +
            '             <td>' + timeTable[i]['room_no'] + '</td>';
        table_display.appendChild(tr_data);
    }
    // }
}