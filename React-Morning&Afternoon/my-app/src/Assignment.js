import React, { Component, useEffect } from 'react';
import './styles.css'

class Assignment extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isLoaded: false,
            Data: [],
            error: null,

        };
    }

    componentDidMount() {
        fetch("https://jsonplaceholder.typicode.com/users")
            .then(response => response.json())
            .then((result) => {
                this.setState({
                    isLoaded: true,
                    Data: result
                });

            },
                (error) => {
                    this.setState({ error: error });
                }
            )
    }

    delete(val) {
        let delData = [];
        delData = this.state.Data.filter((item) => item.id !== val);
        this.setState({ Data: delData });

    }


    render() {
        const { error, isLoaded } = this.state;

        if (error) {
            return <div><label>{error}</label></div>
        }
        else if (!isLoaded) {
            return <div> <label>Data Yet to Load</label></div>
        }

        else {

            return (
                < div class="total">
                    <h1>Table using React</h1>
                    <table id="data">
                        <thead>
                            <tr>
                                <th id="t1">Id</th>
                                <th>Name</th>
                                <th>User</th>
                                <th>Email</th>
                            </tr>

                        </thead>
                        <tbody>
                            {
                                this.state.Data.map((Input, index) => {
                                    return <tr>
                                        <td>{Input.id}</td>
                                        <td>{Input.name}</td>
                                        <td>{Input.username}</td>
                                        <td>{Input.email}</td>
                                        <td> <button onClick={() => { this.delete(Input.id) }}>X</button></td>

                                    </tr>
                                })
                            }
                        </tbody>
                    </table>
                </div >
            );
        }


    }
}


export default Assignment;
