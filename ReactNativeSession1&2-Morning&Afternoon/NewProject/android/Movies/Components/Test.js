/* eslint-disable prettier/prettier */
// import React, { Component } from 'react';
// import { View, Text, StyleSheet, Button, FlatList } from 'react-native';
// //import navigate from 'navigation';

// export default class Test extends Component {
//     state = {
//         data: [],
//     };
//     async function fetchMovies() {
//     const response = await fetch('https://api.themoviedb.org/3/movie/550?api_key=d3fddab5b7eb58608ea30d3a66cab664&/discover/movie?sort_by=popularity.desc');
//     // waits until the request completes...
//     console.log(response);
// }


// componentWillMount() {
//     this.fetchData();
// }

// fetchData = async () => {
//     const response = await fetch("https://jsonplaceholder.typicode.com/users");
//     const json = await response.json();
//     this.setState({ data: json.results });
// };

// render() {
//     return (
//         <View>
//             <FlatList
//                 data={this.state.data}
//                 renderItem={({ item }) =>
//                     <Text>
//                         {`${item.name} ${item.id}`}
//                     </Text>}
//             />
//         </View>
//     );
// }
//}











/* eslint-disable prettier/prettier */

/* eslint-disable prettier/prettier */
// import React from 'react';
// import { View, Text, StyleSheet, Button } from 'react-native';
// import navigate from 'navigation';


// const Test = ({ navigation }) => {
//     return (

//         <View >
//             <Text>Home Scree2n</Text>
//             <Button
//                 title="Go to Main"
//                 onPress={() => navigation.navigate('Main')}
//             />
//         </View>
//     );
// };


// NavBar.defaultProps = {
//     title: 'Shopping List',
// };

// const styles = StyleSheet.create({

// });

// export default Test;





// fetching from api

// import React, { useState, useEffect } from 'react';
// import { View, Text, StyleSheet, FlatList, ActivityIndicator } from 'react-native';

// const Test = () => {

//     const [isLoading, setLoading] = useState(true);
//     const [data, setData] = useState([]);

//     useEffect(() => {
//         fetch(https://api.themoviedb.org/3/movie/550?api_key=d3fddab5b7eb58608ea30d3a66cab664')
//             .then((response) => response.json())
//             .then((json) => setData(json.movies))
//             .catch((error) => console.error(error))
//             .finally(() => setLoading(false));
//     }, []);

//     return (
//         <View >
//             {isLoading ? <ActivityIndicator /> : (
//                 <FlatList
//                     data={data}
//                     keyExtractor={({ id }, index) => id}
//                     renderItem={({ item }) => (
//                         <Text>{item.title}, {item.releaseYear}</Text>
//                     )}
//                 />
//             )}
//         </View>

//     );

// };


// const styles = StyleSheet.create({

// });

// export default Test;






