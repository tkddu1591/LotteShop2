import React from "react";
import message from "../../product/complete/Message";
import axios from "axios";

function RequiredInformation({register, errors, watch}) {
    return <>
        <section>
            <table>
                <caption>필수 정보입력</caption>
                <tbody>
                    <tr>
                        <th><span className="essential">*</span>아이디</th>
                        <td><input type="text" name="km_uid"
                                   placeholder="아이디 입력"
                                   {...register("uid", {
                                       required: "아이디를 입력해 주세요.",
                                       pattern: {
                                           value: /^[a-z]+[a-z0-9]{3,12}$/,
                                           message: '아이디를 형식에 맞춰 입력해 주세요'
                                       },
                                       validate: {
                                           value: async (value) => {
                                               let test;
                                               await axios.post(`${process.env.REACT_APP_API_ROOT}/member/checkUid`, {uid: value})
                                                   .then((response) => {
                                                       test = response.data;
                                                   })
                                               if (test !== 0) {
                                                   return '중복된 아이디가 있습니다.'
                                               }
                                           },
                                       }

                                   })}
                                   style={errors.uid && {border: 'solid 2px red'}} required/> <span
                            className="msgSId">&nbsp;&nbsp;영문, 숫자로
										4~12자까지 설정해 주세요.</span>
                            {errors.uid && <div style={{color: 'red'}}>{(errors.uid.message)}</div>}
                        </td>

                    </tr>
                    <tr>
                        <th><span className="essential">*</span>비밀번호</th>
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
                        <th><span className="essential">*</span>비밀번호확인</th>
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
                    </tr>
                </tbody>
            </table>
        </section>
    </>
}

export default RequiredInformation;