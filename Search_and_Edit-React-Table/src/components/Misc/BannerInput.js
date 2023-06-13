import React, { useState } from "react";
const BannerInput = ({ onChangeUserName }) => {
    const [isDisabled, setIsDisabled] = useState(false);

    const handleBlur = () => {
        setIsDisabled(true);
    };

    return (
        <div className="form-group">
            <form>
                <label >
                    Student Name:
                    <input
                        type="text"
                        id="userNameInput"
                        placeholder="Enter Name"
                        onChange={onChangeUserName}
                        onBlur={handleBlur}
                        disabled={isDisabled}
                    />
                </label>
            </form>
        </div>
    )
};

export default BannerInput;

