import React from 'react';
import { CssBaseline, Container } from '@material-ui/core';

function StudentData(props) {
    
    const { students } = props;

    if(!students || students.length === 0) { return <p>Not Found</p> }
    return(
        <>
        <CssBaseline />
        <main>
        <div>
            <Container maxWidth = "md" style={{marginTop: '20px'}}>
            
            <table>
                <thead>
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>surName</th>
                        <th>lastName</th>
                        <th>birthDate</th>
                        <th>phoneNumber</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        students.map((student) => 
                            <tr key={student.id}>
                                <td>{student.id}</td>
                                <td>{student.name}</td>
                                <td>{student.surname}</td>
                                <td>{student.lastname}</td>
                                <td>{student.birthDate}</td>
                                <td>{student.phoneNumber}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
            </Container>
        </div>
        </main>
        </>
    )
}

export default StudentData;