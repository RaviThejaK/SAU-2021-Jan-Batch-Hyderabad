/* eslint-disable prettier/prettier */
import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, Image, FlatList, ActivityIndicator, SafeAreaView, ScrollView, Button } from 'react-native';
import styles from './Styles'


const SlideDetails = ({ route }) => {


    return (
        <>
            <Text>{route.params.title1}</Text>
            <Text>{route.params.title1}</Text>
            {/* <View>
                <Text> {item.original_title}</Text>
            </View>
            <View>
                <Image
                    style={styles.image}
                    source={{ uri: `https://image.tmdb.org/t/p/w500${item.backdrop_path}` }}
                />
            </View>
            <View>
                <Text>Overview: {item.overview}</Text>
                <Text>Popular : {item.popularity}</Text>
                <Text>Original Language : {item.original_language}</Text>
                <Text>Ratings : {item.vote_average}</Text>
                <Text>No. of Votes : {item.vote_count}</Text>
                <Text>Release date : {item.release_date}</Text>
            </View> */}
        </>
    );
};



export default SlideDetails;
