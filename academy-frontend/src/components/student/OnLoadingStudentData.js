import React from 'react';

function OnLoadingStudentData(Component) {
    return function LoadingStudentsData({ isLoading, ...props }) {
        if (!isLoading) return <Component {...props} />

        else return (
            <div>
                <h1>Подождите, данные загружаются!</h1>
            </div>
        )
    }
}

export default OnLoadingStudentData;