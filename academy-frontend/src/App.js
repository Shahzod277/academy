import Sidebar from "./components/sidebar/sidebar";
import './app.css';
import StudentData from './components/student/StudentData';

function App() {
  return (
    <div className="App">
      <header className="App-header">
          <div className = "container">
              <Sidebar />
              <div className = "otherPages">
                  <StudentData />
              </div>
          </div>
      </header>
    </div>
  );
}
export default App;
