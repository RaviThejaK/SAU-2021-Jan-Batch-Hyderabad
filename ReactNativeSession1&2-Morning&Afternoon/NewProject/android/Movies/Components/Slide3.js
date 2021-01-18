/* eslint-disable prettier/prettier */
//https://api.themoviedb.org/3/movie/upcoming?api_key=d3fddab5b7eb58608ea30d3a66cab664&language=en-US&page=1
//Upcomming Movies

import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, Image, FlatList, SafeAreaView, ScrollView, Button } from 'react-native';
// import SlideDetails from './SlideDetails';
// import useNavigation from '@react-navigation/native';
// import Footer from './Footer';
import StackNav from './NavigationStack';
import 'react-native-gesture-handler';
import styles from './Styles'


const Slide3 = ({ navigation }) => {


    const [isLoading, setLoading] = useState(true);
    const [movieData, setData] = useState({});


    async function fetchMovies() {
        const response = await fetch('https://api.themoviedb.org/3/movie/upcoming?api_key=d3fddab5b7eb58608ea30d3a66cab664&language=en-US&page=1');
        const data = await response.json();
        const res = await data.results;
        setData(res);

    }

    useEffect(() => {
        console.log('Fetching...');
        fetchMovies();
        console.log(movieData);
        //console.log(movieData2);
    }, [movieData]);

    //const img = ;
    //const img = (imagePath: string) => `https://image.tmdb.org/t/p/w500${movieData.poster_path}`;


    return (
        <>

            <SafeAreaView>
                <ScrollView>
                    <View><Text style={styles.h1}>Upcomming</Text></View>
                    <View>
                        <FlatList
                            data={movieData}
                            keyExtractor={item => item.id}
                            renderItem={
                                ({ item }) =>

                                    <View style={styles.slide}>
                                        <View style={styles.arrange}>
                                            <Image
                                                style={styles.image}
                                                source={{ uri: `https://image.tmdb.org/t/p/w500${item.backdrop_path}` }}
                                            />
                                            <View style={styles.det}>
                                                <Text style={styles.det1}>{item.original_title}</Text>
                                                <Text style={styles.det2}>Popular : {item.popularity}</Text>
                                                <Text style={styles.det3}>Original Language : {item.original_language}</Text>
                                                <Text style={styles.det4}>Ratings : {item.vote_average}</Text>

                                                <Button style={styles.btn} title="Know More" onPress={() => {
                                                    navigation.navigate('SlideDetails',
                                                        {
                                                            title: item.original_title, popularity: item.popularity, backdrop_path: item.backdrop_path,
                                                            original_language: item.original_language, overview: item.overview, runtime: item.runtime,
                                                            title2: item.title, release_date: item.release_date, vote_average: item.vote_average,
                                                            vote_count: item.vote_count,
                                                        });
                                                }} />
                                            </View>
                                        </View>
                                    </View>

                            }
                        />

                    </View>
                    {/* <StackNav /> */}
                </ScrollView>
                {/* <Footer /> */}
            </SafeAreaView>
        </>

    );
};



export default Slide3;
