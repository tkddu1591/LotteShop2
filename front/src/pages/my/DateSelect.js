import {addDays, addMonth, changeDate, changeDateMonth, changeDateMonth2} from "../../store/dateChange";
import {changeDTO} from "../../store/changeDTO";
import React, {useEffect, useState} from "react";

function DateSelect({setPageRequestDTO}){
    let [dateCheck, setDateCheck] = useState('')
    let today = new Date()
    let [startDate, setStartDate] = useState('');
    let [endDate, setEndDate] = useState(changeDate(today));

    let fiveMonth = [];
    for (let i = 0; i < 5; i++) {
        const clone = new Date(today);
        clone.setMonth(today.getMonth() - i)
        fiveMonth.push({date: clone})
    }

    function handleStartDateChange(e) {
        setStartDate(e.target.value)
    }

    function handleEndDateChange(e) {
        setEndDate(e.target.value)
    }

    useEffect(() => {
        changeDTO(setPageRequestDTO, 'startDate', null)
        changeDTO(setPageRequestDTO, 'endDate', endDate + 'T23:59:59')
        changeDTO(setPageRequestDTO, 'pg', 1)
    }, []);

    return<>
        <div className="byDate">
            <span className="tit">기간별조회</span>
            <ul className="date_3ea">
                <li><a className={dateCheck === 'week' ? 'on' : ''}
                       onClick={() => {
                           setDateCheck('week')
                           setEndDate(changeDate(today))
                           setStartDate(changeDate(addDays(today, -7)))
                       }}><em>1</em>주일</a></li>
                <li><a className={dateCheck === 'week2' ? 'on' : ''}
                       onClick={() => {
                           setDateCheck('week2')
                           setEndDate(changeDate(today))
                           setStartDate(changeDate(addDays(today, -15)))
                       }}><em>15</em>일</a></li>
                <li><a className={dateCheck === 'month' ? 'on' : ''}
                       onClick={() => {
                           setDateCheck('month')
                           setEndDate(changeDate(today))
                           setStartDate(changeDate(addMonth(today, -1)))
                       }}
                ><em>1</em>개월</a></li>
            </ul>
            <ul className="date_5ea">
                {fiveMonth.map((item, index) => {
                    return <li key={item.date}><a
                        className={dateCheck === index ? 'on' : ''}
                        onClick={() => {
                            setDateCheck(index)
                            setEndDate(changeDateMonth(item.date))
                            setStartDate(changeDateMonth2(item.date))
                        }}
                    ><em>
                        {item.date.getMonth() + 1}</em>월</a></li>
                })}
            < /ul>
            <p>
                <input type="date" name="begin" onChange={(e) => {
                    handleStartDateChange(e)
                }}
                       value={startDate}/>
                <span>~</span>
                <input type="date" name="end" onChange={(e) => {
                    handleEndDateChange(e)
                }}
                       value={endDate}/>
            </p>
            <button className="btnConfirm" onClick={(e) => {
                changeDTO(setPageRequestDTO, 'startDate', startDate + 'T00:00:00')
                changeDTO(setPageRequestDTO, 'endDate', endDate + 'T23:59:59')
                changeDTO(setPageRequestDTO, 'pg', 1)
            }}>조회하기
            </button>
        </div></>

}

export default DateSelect;