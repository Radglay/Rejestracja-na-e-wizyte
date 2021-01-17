import React, { Component } from 'react';
import ImageGallery from 'react-image-gallery';
import "react-image-gallery/styles/css/image-gallery.css"
class Slider extends Component {
  render() {
    const images = [
      {
        original: 'https://anaesthesiaacademy.ie/wp-content/uploads/2015/04/slide-3.jpg',
      },
      {
        original: 'https://www.eucodis-enzymes.com/fileadmin/04_Technology/eucodis-enzymes-technology-slider.jpg',
      },
      {
        original: 'https://anaesthesiaacademy.ie/wp-content/uploads/2015/04/slide-2.jpg',
      },
    ];
    return (
      <div style={{ marginTop: "100px", marginBottom: "40px" }}>
        <ImageGallery slideInterval={6000} autoPlay={true} showThumbnails={false} showNav={false} showPlayButton={false} showFullscreenButton={false} items={images} />
      </div>

    );
  }
}

export default Slider;