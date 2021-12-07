
function App() {
  return (
    <div className="App">
      <header className="App-header">
          <span>Hello World!!!</span>
      </header>
    </div>
  );
}

const dict = {
  duck: 'quack',
  dog: 'wuff',
  mouse: 'squick',
  hamster: 'squick'
};

const res = Object.entries(dict);

const arr = res.filter(([key, value]) => value === 'squick')
                      .map(([, value]) => value);
console.log(arr);


export default App;
