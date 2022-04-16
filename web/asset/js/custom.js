function getAuto() {
    $.get('http://localhost/Projet_Transport/Api/getallauto',
            function (data, status) {
                data.forEach(element => {
                    if (element['itineraire_1'] == 'Abe/Tana') {
                        let card_body = '<div class="timg"><img src="data:image;base64, ' + element['image_auto'] + '" alt="Card image"/></div>' +
                                '<div class="t-box">' +
                                '<h3>Depart: <span> ' + element['heure_de_depart_1'] + '</span></h3>' +
                                '<p class="card-text">Numero: ' + element['num_voiture'] + '<br>' +
                                'Type: ' + element['type'] + '<br>' +
                                'Nombre de place :' + element['nombre_de_place'] + '<br>Prix 1 place : 12000 Ar</p>';
                        switch (element['heure_de_depart_1']) {
                            case '04:00:00':
                                var html = card_body +
                                        '<a href="reservation.xhtml?h=4&it=1"><button class="btn btn-primary btn-lg btn-ornge-res">Reserver</button></a></div>';
                                $('#4abetana').html(html);
                                break;
                            case '07:00:00':
                                var html = card_body +
                                        '<a href="reservation.xhtml?h=7&it=1"><button class="btn btn-primary btn-lg btn-ornge-res">Reserver</button></a></div>';
                                $('#7abetana').html(html);
                                break;
                            case '10:00:00':
                                var html = card_body +
                                        '<a href="reservation.xhtml?h=10&it=1"><button class="btn btn-primary btn-lg btn-ornge-res">Reserver</button></a></div>';
                                $('#10abetana').html(html);
                                break;
                            case '13:00:00':
                                var html = card_body +
                                        '<a href="reservation.xhtml?h=13&it=1"><button class="btn btn-primary btn-lg btn-ornge-res">Reserver</button></a></div>';
                                $('#13abetana').html(html);
                                break;
                            default:
                                break;
                        }
                    }
                    if (element['itineraire_2'] == 'Tana/Abe') {
                        let card_body = '<div class="timg"><img src="data:image;base64, ' + element['image_auto'] + '" alt="Card image"/></div>' +
                                '<div class="t-box">' +
                                '<h3>Depart: <span> ' + element['heure_de_depart_2'] + '</span></h3>' +
                                '<p class="card-text">Numero: ' + element['num_voiture'] + '<br>' +
                                'Type: ' + element['type'] + '<br>' +
                                'Nombre de place :' + element['nombre_de_place'] + '<br>Prix 1 place : 12000 Ar</p>';
                        switch (element['heure_de_depart_2']) {
                            case '04:00:00':
                                var html = card_body +
                                        '<a href="reservation.xhtml?h=4&it=2"><button class="btn btn-primary btn-lg btn-ornge-res">Reserver</button></a></div>';
                                $('#4tanaabe').html(html);
                                break;
                            case '07:00:00':
                                var html = card_body +
                                        '<a href="reservation.xhtml?h=7&it=2"><button class="btn btn-primary btn-lg btn-ornge-res">Reserver</button></a></div>';
                                $('#7tanaabe').html(html);
                                break;
                            case '10:00:00':
                                var html = card_body +
                                        '<a href="reservation.xhtml?h=10&it=2"><button class="btn btn-primary btn-lg btn-ornge-res">Reserver</button></a></div>';
                                $('#10tanaabe').html(html);
                                break;
                            case '13:00:00':
                                var html = card_body +
                                        '<a href="reservation.xhtml?h=13&it=2"><button class="btn btn-primary btn-lg btn-ornge-res">Reserver</button></a></div>';
                                $('#13tanaabe').html(html);
                                break;
                            default:
                                break;
                        }
                    }
                });
            },
            "json"
            );
}

function reserver() {
    let nom = $('#nom').val();
    let prenoms = $('#prenoms').val();
    let cin_client = parseInt($('#cin').val());
    let lieu_cin = $('#lieu_cin').val();
    let date_cin = $('#date_cin').val();
    let telephone = $('#telephone').val();
    let email = $('#email').val();
    let adresse = $('#adresse').val();
    let date_co = $('#date_co').val();
    let itineraire = $('#itineraire').val();
    let nb_de_place_reserve = $('#nb_place').val();
    let heure_co = $('#heure_co').val();
    if (nom != "" && prenoms != "" && cin_client != "" && lieu_cin != "" && date_cin != "" && telephone != "" && email != "" && adresse != "" && date_co != "" && heure_co != "" && itineraire != "" && nb_de_place_reserve != "")
    {
        $.post('http://localhost/Projet_Transport/Api/reserver',
                {
                    nom: nom,
                    prenoms: prenoms,
                    cin_client: parseInt(cin_client),
                    lieu_cin: lieu_cin,
                    date_cin: date_cin,
                    telephone: telephone,
                    email: email,
                    adresse: adresse,
                    date_co: date_co,
                    itineraire: itineraire,
                    nb_de_place_reserve: nb_de_place_reserve,
                    heure_co: heure_co
                },
                function (data, status) {

                    if (status) {
                        let obj = JSON.parse(data);
                        if (obj.success == true)
                        {
                            $('input').val("");
                            $("#total").html("0 ");
                            $("#response").html("<div class='alert alert-success'>" + obj.message + "</div>");
                            location.href = "#";
                        } else
                        {
                            $("#response").html("<div class='alert alert-warning'>" + obj.message + "</div>");
                            location.href = "#";
                        }
                    }
                }
        ,
                "text"
                );
    } else
    {
        $("#response").html("<div class='alert alert-danger'>Veuillez remplir tous les champs</div>");
        location.href = "#";
    }
}

$(document).ready(function ()
{
    "use strict";
    getAuto();
    new WOW().init();
    var header = $('.header');
    $(".home1").owlCarousel({
        autoPlay: 3000,
        stopOnHover: true,
        navigation: true,
        paginationSpeed: 1000,
        goToFirstSpeed: 2000,
        singleItem: true,
        autoHeight: true,
        navigationText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
        itemsDesktop: [1199, 2],
        itemsDesktopSmall: [980, 2],
        itemsTablet: [768, 1],
        itemsMobile: [479, 1],
    });

    setHeader();
    $(window).on('resize', function ()
    {
        setHeader();
    });
    $(document).on('scroll', function ()
    {
        setHeader();
    });
    function setHeader()
    {
        if ($(window).scrollTop() > 100)
        {
            header.addClass('scrolled');
            console.log("added")
        } else
        {
            header.removeClass('scrolled');
        }
    }


    $('#date_co').change(function ()
    {
        let date_co = $("#date_co").val();
        let heure_co = $("#heure_co").val();
        let today = new Date().getFullYear().toString() + '-' + (new Date().getMonth() + 1).toString() + '-' + new Date().getDate().toString();
        let itineraire = $('#itineraire').val();
        if (date_co != null && heure_co != null && itineraire != null)
        {
            if (new Date(date_co) <= new Date(today))
            {
                $('#submit').attr('disabled', true);
                $("#info").html("<p style='color:red;text-align:canter;'>invalid date commande</p>");
            } else
            {
                $('#submit').attr('disabled', false);
                $("#info").html("");
            }
        }
    });

    $("#submit").click(function () {
        reserver();
    });
});



  