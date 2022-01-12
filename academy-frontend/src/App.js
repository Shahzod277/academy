import Sidebar from "./components/sidebar/sidebar";
import './app.css';
import Student from "./components/student/Student";

function App() {
  return (
    <div className="App">
      <header className="App-header">
          <div className = "container">
              <Sidebar />
              <div className = "otherPages">
                  <Student />
              </div>
          </div>
      </header>
    </div>
  );
}
export default App;
