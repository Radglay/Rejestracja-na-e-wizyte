import React, { Component } from 'react';
import Menu from "../Menu"
import Slider from "./Slider"
import "../../css/mainpage.css"

class MainPage extends Component {

    render() {
        return (
            <div className="mainpage">
                <Menu />
                <Slider />
                <div style={{ width: "1400px", borderBottom: "2px black solid", marginBottom: "15px" }}>
                    <span style={{ fontSize: "45px", fontWeight: "bold" }}>E-rejestracja</span>
                </div>
                <div style={{ width: "1400px", marginBottom: "40px" }}>
                    <span style={{ fontSize: "27px" }}>Celem elektronicznej rejestracji jest zwiększenie dostępności do usług medycznych podczas pandemii koronawirusa. Podczas rejestracji prosimy Państwa o dokładne sprawdzenie i podanie prawidłowych danych oraz adresów e-mail.</span>
                </div>
                <div style={{ width: "1400px", borderBottom: "2px black solid", marginBottom: "15px" }}>
                    <span style={{ fontSize: "45px", fontWeight: "bold" }}>Aktualności</span>
                </div>
                <div style={{ width: "1400px", marginBottom: "20px" }}>
                    <span style={{ fontSize: "20px" }}>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ex dolor, vestibulum nec dolor eget, convallis gravida ligula. Vestibulum non consectetur urna. In vel dui congue, fermentum nibh et, venenatis nibh. Sed elit turpis, volutpat quis suscipit eget, vestibulum ac nunc. Aliquam aliquam nisi quis mi semper facilisis. Mauris scelerisque enim libero. Quisque hendrerit lectus mi, dignissim malesuada metus vestibulum nec. Duis lacinia finibus justo, sit amet gravida turpis scelerisque vel. Aenean varius felis eu sapien commodo, sit amet faucibus felis molestie. Nulla odio mi, luctus eu orci vel, ornare interdum augue. Suspendisse potenti. Praesent sit amet suscipit dolor. Vestibulum tincidunt, nibh nec facilisis luctus, elit odio vestibulum purus, malesuada venenatis sapien justo eu diam. Morbi facilisis magna justo, eu varius risus finibus sed. Cras iaculis velit libero, vel convallis lacus fringilla et. Praesent mattis faucibus augue vitae consequat.

                    Maecenas feugiat metus sit amet urna convallis, ut faucibus nunc sollicitudin. Nullam felis nulla, ultrices ut scelerisque sed, finibus a orci. Aenean vitae fermentum nulla, ac sagittis urna. Praesent sodales lacus vel nibh varius mattis. Sed iaculis lorem in ex rhoncus, quis tincidunt justo laoreet. Curabitur in massa sapien. Curabitur at lobortis enim. Vestibulum luctus tincidunt lacus non faucibus. Sed elementum sagittis quam sit amet mollis. In at nulla nec tellus euismod vehicula. Mauris tellus ipsum, semper nec sapien id, iaculis rhoncus tellus. Donec posuere lacus in gravida faucibus. Curabitur vel porta massa, ut tempus tortor. Mauris tincidunt elementum eros eu blandit.

                    Quisque in ipsum eget dolor auctor pharetra vitae sed velit. Duis vitae gravida magna. Nullam quis velit id augue convallis malesuada. Curabitur a ullamcorper velit. Suspendisse semper mollis metus at pretium. Cras nec nibh neque. Vivamus vehicula feugiat lacus, malesuada fermentum est ornare eget. Quisque dictum et lectus et hendrerit.

                    Vestibulum feugiat placerat mauris sed viverra. Quisque lacinia erat at iaculis imperdiet. Maecenas vitae dignissim dui. Cras ut libero eget lorem auctor dictum blandit at magna. Nunc congue ligula leo, faucibus scelerisque ipsum tempor at. Nullam non cursus metus. Nulla ante augue, suscipit nec tempus at, faucibus quis nibh. Mauris suscipit sit amet libero id bibendum.

                    Cras efficitur magna id cursus suscipit. Ut mattis, velit et congue porttitor, justo dolor auctor quam, vel porta dui ante a massa. Morbi id lectus gravida, sollicitudin leo ut, consequat urna. Cras eu sollicitudin turpis. Suspendisse tortor neque, viverra eu convallis sit amet, laoreet eget nunc. Nulla odio purus, convallis sit amet placerat sed, accumsan at quam. Curabitur quis commodo orci. Vivamus ultricies pharetra sapien, ut aliquet tellus condimentum vel. Donec dapibus mi aliquet sem fringilla feugiat. Nunc vestibulum dolor eget nunc iaculis, quis ullamcorper lorem facilisis. Praesent eleifend vehicula velit, quis euismod nisl maximus et. Suspendisse efficitur mauris vitae tellus pretium rhoncus. Mauris ultrices venenatis nibh feugiat eleifend. Quisque in sodales nibh. In pellentesque, libero vel ultricies dapibus, mi magna sodales diam, eu venenatis nisl est vel nisi.

                    Integer ut convallis tellus. Maecenas a felis auctor, congue sapien non, mollis lorem. Integer lacinia lorem id volutpat accumsan. Integer vehicula faucibus convallis. Mauris vulputate eros ligula, eget imperdiet mauris congue non. Vestibulum pellentesque a mauris sit amet pretium. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Integer fermentum, enim et sodales posuere, quam ipsum pretium lorem, et mattis nunc nibh non ante.

                    Suspendisse cursus dolor quis diam tempor cursus. Fusce vitae ipsum ultricies, tincidunt nulla et, volutpat lectus. Quisque id tortor in ex rhoncus auctor. Sed ac quam id eros sagittis tincidunt et non quam. Donec nulla neque, varius ac dolor at, ultrices consequat lacus. Sed sit amet mollis ante. Vivamus pellentesque lobortis finibus.

                    Mauris at euismod lectus. Phasellus quis rutrum ex. Maecenas a orci lectus. Suspendisse rhoncus enim ipsum, sed suscipit ante rhoncus in. Proin rutrum risus eget bibendum tempor. Integer luctus euismod enim ut feugiat. Vivamus ullamcorper, arcu vel fringilla sagittis, quam justo faucibus arcu, nec luctus lectus urna vitae libero. Pellentesque egestas ultricies magna, eu porta felis vestibulum non. Donec pellentesque eros sed quam vestibulum interdum. Ut tempus tortor vel lorem molestie, eu tristique odio volutpat.

                    Mauris scelerisque placerat est. Duis sed risus consectetur, semper mi non, volutpat ligula. Nam gravida eros non elit bibendum, quis bibendum magna scelerisque. Fusce porttitor nibh sed ante lacinia hendrerit. Sed ultrices mauris quis leo pellentesque, eget euismod turpis molestie. Sed ultricies libero tellus, sit amet fringilla leo dignissim ac. Nam lacinia nisl ullamcorper velit laoreet molestie.

                    Sed quis gravida mauris. Duis faucibus rutrum tempor. Cras ultrices, lorem rutrum porttitor luctus, nunc tellus efficitur ex, at maximus risus erat sit amet risus. Nulla ac lectus rhoncus, fringilla eros sit amet, elementum neque. Vestibulum lorem diam, feugiat sit amet ipsum quis, pulvinar pharetra neque. Proin sed sapien aliquet, convallis leo et, lacinia libero. Aenean orci enim, ultrices ut turpis vel, posuere efficitur sem. Aliquam sagittis velit et risus mollis, vitae commodo turpis cursus. Sed dapibus commodo libero, id vulputate enim commodo quis. Duis eleifend nisi risus, in congue nulla venenatis a.</span>
                </div>
                <div className="footer">
                    <span>© 2020 All rights reserved</span>
                    <span>Telefon: 111111111</span>
                    <span>Adres: ul. Krakowska 32</span>
                </div>
            </div>
        );
    }
}

export default MainPage;