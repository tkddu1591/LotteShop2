import React, {useEffect, useState} from "react";
import message from "../../product/complete/Message";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import {createTokenHeader} from "../../../slice/tokenSlice";

function MyRequiredInformation({register, errors, watch, member, nowPassCheck, setDivName, handleSubmit}) {

    const onValid = async (data) => {
        axios.post(`${process.env.REACT_APP_API_ROOT}/member/passChagne`, {
            uid: member.uid,
            exPassword: data.exPassword,
            newPassword: data.newPassword
        }).then(() => {
                alert('수정되었습니다.')
                setDivName('home')
            }
        ).catch(() => {
            alert('현재 비밀번호가 일치하지 않습니다.')
        })
    }
    useEffect(() => {

    }, []);
    return <>
        <form onSubmit={handleSubmit(onValid)}>
            <section>
                <table>
                    <caption>필수 정보</caption>
                    <tbody>
                        <tr>
                            <input type="hidden" {...register('uid')} value={member.uid}/>
                            <th><span className="essential"></span>현재 비밀번호 확인</th>
                            <td><input type="password" name="km_pass"
                                       placeholder="비밀번호 확인" required
                                       {...register('exPassword', {
                                           required: "현재 비밀번호를 입력해주세요.",
                                       })}
                                       style={errors.nowPass && {border: 'solid 2px red'}}
                            /> <span
                                className="msgPass">&nbsp;&nbsp;현재 비밀번호 입력</span>
                                {errors.nowPass && <div style={{color: 'red'}}>{errors.nowPass.message}</div>}
                                {nowPassCheck && <div style={{color: 'green'}}>확인되었습니다.</div>}
                            </td>
                        </tr>
                        <tr>
                            <th><span className="essential"></span>비밀번호</th>
                            <td><input type="password" name="km_pass"
                                       placeholder="비밀번호 입력" required
                                       {...register('newPassword', {
                                           required: "비밀번호를 입력해 주세요.",
                                           pattern: {
                                               value: /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{7,15}$/,
                                               message: '비밀번호를 형식에 맞춰 입력해주세요'
                                           },
                                       })}
                                       style={errors.pass && {border: 'solid 2px red'}}

                            /> <span
                                className="msgPass">&nbsp;&nbsp;영문,
										숫자, 특수문자를 조합하여 7~15자까지 설정하세요.</span>
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
                                               notValue: (value) => value === watch().newPassword || '비밀번호가 일치하지 않습니다.',
                                           }
                                       })}
                                       style={errors.pass2 && {border: 'solid 2px red'}}
                            /> <span
                                className="msgPass">&nbsp;&nbsp;비밀번호 재입력</span>
                                {errors.pass2 && <div style={{color: 'red'}}>{errors.pass2.message}</div>}
                            </td>
                        </tr>
                    </tbody>
                </table>

                <div>
                    <input type="submit" className="join" value="수정하기"/>
                </div>
            </section>
        </form>
    </>
}

export default MyRequiredInformation;