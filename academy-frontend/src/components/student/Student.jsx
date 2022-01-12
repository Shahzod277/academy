import React, {useState, useEffect} from 'react';
import axios from 'axios';
import StudentData from './StudentData';
import OnLoadingStudentData from "./OnLoadingStudentData";

function Student() {

    const DataLoading = OnLoadingStudentData(StudentData);
    const [appState, setAppState] = useState(
        {
            // loading: false,
            students: null,
        }
    );

    useEffect(() => {
        // setAppState({loading: true})
        const apiUrl = 'http://localhost:8080/api/student/all';
        axios.get(apiUrl).then((resp) => {
            const allStudents = resp.data;
            setAppState({
                // loading: false,
                students: allStudents
            });
        });
    }, [setAppState]);

    return(
        <div className='student'>
            {/*<DataLoading isLoading={appState.loading} students={appState.students} />*/}
            <DataLoading students={appState.students} />
        </div>
    );
}

export default Student;