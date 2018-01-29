import React from 'react'
import ReactDOM from 'react-dom'


class App extends React.Component{
    render(){
        return(<div>
                <div>Details of the person</div>
        return(<div id="instrctions">
                <p><b>INSTRUCTIONS:</b></p>
               <ul>
                   <li>Put face straight</li>
               </ul>
            </div>
        )
    }
    componentWillMount(){
    }
}

ReactDOM.render(<App />, document.getElementById("container1"));