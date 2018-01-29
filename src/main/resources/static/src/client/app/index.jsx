import React from 'react'
import ReactDOM from 'react-dom'


class App extends React.Component{
    render(){
        return(<div>
                <div>Details of the person</div>
            </div>
        )
    }
    componentWillMount(){
    }
}

ReactDOM.render(<App />, document.getElementById("container2"));