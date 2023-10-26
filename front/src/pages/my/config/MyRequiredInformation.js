import React from "react";
import message from "../../product/complete/Message";
import axios from "axios";

function MyRequiredInformation({register, errors, watch, member, setPassChange}) {

    const handleMaskText = (text) => {
        // Assuming you want to mask from the 4th character onward with asterisks
        const maskedText = text.substring(0, 3) + '*'.repeat(text.length - 3);
        return (maskedText);
    }
    return <>
        <section>
            <table>
                <caption>필수 정보</caption>
                <tbody>
                    <tr>
                        <th><span className="essential"></span>아이디</th>
                        <td><input type="text" name="km_uid" value={handleMaskText(member.uid)}
                                   style={{backgroundColor: 'lightgray'}}/>
                        </td>

                    </tr>
                    <tr>
                        <th><span className="essential"></span>비밀번호</th>
                        <td>
                            <button type="button" name="km_uid" style={{
                                border: "2px outset #E60012",
                                width: '180px', height: '35px',
                                fontSize: '12px',
                                verticalAlign: 'middle',  background: 'none'
                            }}  onClick={()=>{setPassChange(true)}}>비밀번호 변경</button>
                        </td>

                    </tr>
                    {/*      <tr>
                        <th><span className="essential"></span>비밀번호</th>
                        <td><input type="password" name="km_pass"
                                   placeholder="비밀번호 입력" required
                                   {...register('pass', {
                                       required: "비밀번호를 입력해 주세요.",
                                       pattern: {
                                           value: /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{7,15}$/,
                                           message: '비밀번호를 형식에 맞춰 입력해주세요'
                                       }
                                   })}
                                   style={errors.pass && {border: 'solid 2px red'}}

                        /> <span
                            className="msgPass">&nbsp;&nbsp;영문,
										숫자, 특수문자를 조합하여 7~15자까지 설정해 주세요.</span>
                            {errors.pass && <div style={{color: 'red'}}>{errors.pass.message}</div>}
                        </td>
                    </tr>
                    <tr>
                        <th><span className="essential"></span>비밀번호확인</th>
                        <td><input type="password" name="km_pass"
                                   placeholder="비밀번호 확인" required
                                   {...register('pass2', {
                                       required: "비밀번호와 같게 입력해주세요.",
                                       validate: {
                                           notValue: (value) => value === watch().pass || '비밀번호가 일치하지 않습니다.',
                                       }
                                   })}
                                   style={errors.pass2 && {border: 'solid 2px red'}}
                        /> <span
                            className="msgPass">&nbsp;&nbsp;비밀번호 재입력</span>
                            {errors.pass2 && <div style={{color: 'red'}}>{errors.pass2.message}</div>}
                        </td>
                    </tr>*/}
                </tbody>
            </table>
        </section>
    </>
}

export default MyRequiredInformation;