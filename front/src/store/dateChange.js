import React from "react";

let today = new Date()

function addDays(date, days) {
    const clone = new Date(date);
    clone.setDate(date.getDate() + days)
    return clone;
}

function addMonth(date, months) {
    const clone = new Date(date);
    clone.setMonth(date.getMonth() + months)
    return clone;
}

function changeDate(date) {
    let year = date.getFullYear(); // 년도
    let month = String(date.getMonth() + 1).padStart(2, '0'); // 월을 가져오고 두 자리로 패딩합니다.
    let day = String(date.getDate()).padStart(2, '0'); // 일을 가져오고 두 자리로 패딩합니다.
    return year + '-' + month + '-' + day
}


function changeDateMonth(date) {


    let last = new Date(date.getFullYear(), date.getMonth() + 1, 0);
    let year = last.getFullYear(); // 년도
    let month = String(last.getMonth() + 1).padStart(2, '0'); // 월을 가져오고 두 자리로 패딩합니다.
    let day = String(last.getDate()); // 일을 가져오고 두 자리로 패딩합니다.
    return year + '-' + month + '-' + day
}

function changeDateMonth2(date) {
    let year = date.getFullYear(); // 년도
    let month = String(date.getMonth() + 1).padStart(2, '0'); // 월을 가져오고 두 자리로 패딩합니다.
    let day = '01'; // 일을 가져오고 두 자리로 패딩합니다.
    return year + '-' + month + '-' + day
}


function divisionCheck(item) {

    if (item === null) {
        return <td className="type" style={{color: 'red'}}>사용</td>
    } else if (item && (parseInt(item.substring(0, 10).replaceAll('-', ''))
        < parseInt(changeDate(today).replaceAll('-', '')))) {
        return <td className="type" style={{color: 'red'}}>기간만료</td>
    } else
        return <td className="type" style={{color: 'green'}}>적립</td>
}


function noteCheck(item) {

    if (item === null) {
        return <td className="type" style={{color: 'red'}}>사용</td>
    } else if (item && (parseInt(item.substring(0, 10).replaceAll('-', ''))
        <= parseInt(changeDate(today).replaceAll('-', '')))) {
        return <td className="type" style={{color: 'red'}}>기간만료</td>
    } else
        return <td className="type" style={{color: 'green'}}>적립</td>
}

export {divisionCheck, changeDate, addDays, changeDateMonth, changeDateMonth2, addMonth}