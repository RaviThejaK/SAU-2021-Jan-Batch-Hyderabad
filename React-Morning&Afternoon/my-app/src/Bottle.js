import React, { useState } from 'react';

// useState ==> hook
// state management

function Bottle() {
    //const [myBottleName, setMyBottleName] = useState('hello');
    const [input1, setMyInput1] = useState(0);
    const [input2, setMyInput2] = useState(0);
    const [Result, setResult] = useState(0);

    const onChangeinput1 = (e) => {
        setMyInput1(e.target.value);
    }

    const onChangeinput2 = (e) => {
        setMyInput2(e.target.value);
    }

    const onChangeButton = () => {
        setResult(Number(input1) + Number(input2));
    }

    //const onChangeBottleName = (e) => {
    //    setMyBottleName(e.target.value);
    //};

    return (
        // <div>
        //    <input value={myBottleName} onChange={onChangeBottleName}></input>
        //    <p>{myBottleName}</p>
        //</div>

        <div>
            <input value={input1} onChange={onChangeinput1} /><br></br>
            <button onClick={onChangeButton}>Add</button>
            <input value={input2} onChange={onChangeinput2} /><br></br>
            <button onClick={onChangeButton}>Equal To</button>
            <p>{Result}</p>
        </div>
    );
}

export default Bottle;
