import React from "react";

function ratingCheck(value) {
    if (value >= 4.5)
        return <td><span className="rating star5">상품평</span></td>
    else if (value >= 3.5)
        return <td><span className="rating star4">상품평</span></td>
    else if (value >= 2.5)
        return <td><span className="rating star3">상품평</span></td>
    else if (value >= 1.5)
        return <td><span className="rating star2">상품평</span></td>
    else
        return <td><span className="rating star1">상품평</span></td>
}
export default ratingCheck;