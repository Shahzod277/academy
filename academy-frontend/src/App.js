import Sidebar from "./components/sidebar/sidebar";
import './app.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
          <div className = "container">
              <Sidebar />
              <div className = "otherPages"> other pages</div>
          </div>
      </header>
    </div>
  );
}
export default App;
