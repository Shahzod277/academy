import Sidebar from "./components/sidebar/sidebar";
import Region from "./components/pages/region";
import './app.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
          <div className = "container">
              <Sidebar />
              <div className = "otherPages"><Region /></div>
          </div>
      </header>
    </div>
  );
}
export default App;
