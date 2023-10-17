import React, {useEffect, useState} from "react";
import {paste} from "@testing-library/user-event/dist/paste";

function Delivery({member, changeOrderEnd, orderEnd}) {

    const [formattedPhoneNumber, setFormattedPhoneNumber] = useState(
        orderEnd.recipHp
    );

    /*휴대폰 번호 자동 하이픈*/
    const handlePhoneNumberChange = (e) => {
        const rawPhoneNumber = e.target.value.replace(/-/g, ''); // 기존 하이픈 제거
        const formattedPhoneNumber = autoHyphen(rawPhoneNumber);
        setFormattedPhoneNumber(formattedPhoneNumber); // 상태 업데이트
        changeOrderEnd('recipHp', formattedPhoneNumber)
    };

    const autoHyphen = (value) => {
        // 숫자 이외의 문자와 기존 하이픈 제거
        const rawValue = value.replace(/[^0-9]/g, '');

        if(rawValue.length === 12) {
            return formattedPhoneNumber
        }
        // 특정 위치에 하이픈 추가
        let formattedPhoneNumber2 = '';
        for (let i = 0; i < rawValue.length; i++) {
            if (i === 3 || i === 7) {
                formattedPhoneNumber2 += '-';
            }
            formattedPhoneNumber2 += rawValue[i];
        }


        return formattedPhoneNumber2;
    };

    const handleInputChange = (event, key) => {
        const updateCount = event.target.value
        changeOrderEnd(key, updateCount)
    };

    return <>
        <article className="delivery">
            <h1>배송정보</h1>
            <table>
                <tbody>
                    <tr>
                        <td>주문자</td>
                        <td><input type="text" name="orderer" defaultValue={member.name}
                                   onChange={(e) => {
                                       handleInputChange(e, 'recipName')
                                   }}
                        /></td>
                    </tr>
                    <tr>
                        <td>휴대폰</td>
                        <td>
                            <input
                                type="text"
                                name="hp"
                                value={formattedPhoneNumber}
                                onChange={handlePhoneNumberChange}
                            />
                            <span>- 포함 입력</span>
                        </td>
                    </tr>
                    <tr>
                        <td>우편번호</td>
                        <td>
                            <input type="text" name="zip" defaultValue={member.zip} readOnly
                                   onChange={(e) => {
                                       handleInputChange(e, 'recipZip')
                                   }}/>
                            <input type="button" value="검색"/>
                        </td>
                    </tr>
                    <tr>
                        <td>기본주소</td>
                        <td>
                            <input type="text" name="addr1" defaultValue={member.addr1} readOnly
                                   onChange={(e) => {
                                       handleInputChange(e, 'recipAddr1')
                                   }}
                            />
                        </td>
                    </tr>
                    <tr>
                        <td>상세주소</td>
                        <td>
                            <input type="text" name="addr2" defaultValue={member.addr2}
                                   onChange={(e) => {
                                       handleInputChange(e, 'recipAddr2')
                                   }}/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </article>
    </>
}

export default Delivery;