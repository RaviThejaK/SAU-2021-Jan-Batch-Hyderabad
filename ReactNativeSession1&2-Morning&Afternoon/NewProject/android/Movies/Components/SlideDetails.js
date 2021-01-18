/* eslint-disable prettier/prettier */
import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, Image, FlatList, ActivityIndicator, SafeAreaView, ScrollView, Button } from 'react-native';
import styles from './Styles'
//import Moment from 'react-moment';

const SlideDetails = ({ route }) => {


    return (
        <>
            <ScrollView>
                <View>
                    <Text style={styles.texthead}> {route.params.title}</Text>
                </View>
                <View>
                    <Image
                        style={styles.image2}
                        source={{ uri: `https://image.tmdb.org/t/p/w500${route.params.backdrop_path}` }}
                    />
                </View>
                <View style={styles.textarr}>
                    <Text style={styles.textpar}>Overview: {route.params.overview}</Text>
                    <View style={styles.rem}>
                        <Text>Other Title: {route.params.title2}</Text>
                        <Text >Popular : {route.params.popularity}</Text>
                        <Text>Original Language : {route.params.original_language}</Text>
                        <Text>Ratings : {route.params.vote_average}</Text>
                        <Text>No. of Votes : {route.params.vote_count}</Text>
                        <Text>Release date : {route.params.release_date}</Text>
                        {/* <Moment format="YYYY/MM/DD">
                            {route.params.release_date}
                        </Moment> */}
                    </View>
                </View>
            </ScrollView>
        </>
    );
};



export default SlideDetails;
