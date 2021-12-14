import React, {useState, useEffect} from 'react';
import axios from 'axios';

function Student() {

    const [students, setStudents] = useState();

    useEffect(() => {
        const apiUrl = 'http://localhost:8080/api/student';
        axios.get(apiUrl).then((resp) => {
            const allStudents = resp.data;
            setStudents(allStudents);
        });
    }, [setStudents]);

    return(
        <div className='student'>

        </div>
    );
}

export default Student;